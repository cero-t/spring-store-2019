import Vue from 'vue'

import {
  FETCH_PRODUCT,
  FETCH_PRODUCTS,
  CREATE_PRODUCT,
  UPDATE_PRODUCT,
  DELETE_PRODUCT
} from './mutation-types'

export function fetchProduct ({ commit }, productId) {
  console.log('TODO: fetch product')
  return Vue.http.get(`products/${productId}`)
    .then((response) => commit(FETCH_PRODUCT, response.body.data))
}

export function fetchProducts ({ commit }) {
  return Vue.http.get('catalog/')
    .then((response) => commit(FETCH_PRODUCTS, response.body))
}

export function createProduct ({ commit }, { product, image }) {
  return Vue.http.post('products', product)
    .then((response) => {
      commit(CREATE_PRODUCT, response.body.data)
      return response.body.data.id
    })
    // Only upload image if an image has been defined
    .then((productId) => image && uploadProductImage({ commit }, image, productId))
}

export function updateProduct ({ commit }, { product, image }) {
  return Vue.http.put(`products/${product.id}`, product)
    .then((response) => commit(UPDATE_PRODUCT, response.body.data))
    // Only upload image if an image has been defined
    .then((productId) => image && uploadProductImage({ commit }, image, product.id))
}

export function deleteProduct ({ commit }, productId) {
  return Vue.http.delete(`products/${productId}`)
    .then((response) => commit(DELETE_PRODUCT, productId))
}

export function saveProduct ({ commit, state }, { product, image }) {
  const index = state.all.findIndex((p) => p.id === product.id)

  // update product if it exists or create it if it doesn't
  if (index !== -1) {
    return updateProduct({ commit }, { product, image })
  } else {
    return createProduct({ commit }, { product, image })
  }
}

function uploadProductImage ({ commit }, image, productId) {
  var formData = new global.FormData()

  formData.append('product_id', productId)
  formData.append('product_image', image)

  // Upload (PUT) the product image before resolving the response
  return Vue.http.put('products/upload', formData)
    .then((response) => response.body.data)
    // Since the server has associated the product with the image
    // we now need to refresh (GET) the product data to get this information
    .then(() => fetchProduct({ commit }, productId))
}
