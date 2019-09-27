import * as getters from './getters'
import * as actions from './actions'

import {
  NEW_CART,
  REFRESH_CART,
  RESET_CART
} from './mutation-types'

const initialState = {
  cardId: null,
  total: 0,
  products: []
}

// mutations
const mutations = {
  [NEW_CART] (state, cartId) {
    state.cartId = cartId
  },
  [REFRESH_CART] (state, response) {
    state.products = response.items
    state.total = response.total
  },
  [RESET_CART] (state) {
    state.cartId = null
    state.total = 0
    state.products = []
  }
}

export default {
  state: {...initialState},
  getters,
  actions,
  mutations
}
