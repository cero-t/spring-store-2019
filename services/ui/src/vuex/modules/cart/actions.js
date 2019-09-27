import Vue from 'vue'

import {
  NEW_CART,
  REFRESH_CART,
  RESET_CART
} from './mutation-types'

export function addToCart ({ state, commit }, productId) {
  var event = {
    itemId: productId,
    quantity: 1
  }

  if (!state.cartId) {
    Vue.http.post('cart')
      .then((response) => {
        commit(NEW_CART, response.body.cartId)
        Vue.http.post(`cart/${state.cartId}`, event)
          .then((response) => commit(REFRESH_CART, response.body))
      },
      (response) => console.log(response))
  } else {
    Vue.http.post(`cart/${state.cartId}`, event)
      .then((response) => commit(REFRESH_CART, response.body))
  }
}

export function removeFromCart ({ state, commit }, productId) {
  Vue.http.delete(`cart/${state.cartId}/${productId}`)
    .then((response) => commit(REFRESH_CART, response.body))
}

export function subtractFromCart ({ state, commit }, productId) {
  var event = {
    itemId: productId,
    quantity: -1
  }

  Vue.http.post(`cart/${state.cartId}`, event)
    .then((response) => commit(REFRESH_CART, response.body))
}

export function checkout ({ state, commit }, order) {
  order.cartId = state.cartId
  Vue.http.post(`order`, order)
    .then((response) => {
      commit(RESET_CART)
    })
}
