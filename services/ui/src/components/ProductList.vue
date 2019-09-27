<template>
  <table class="table table-hover product-table">
    <thead>
      <tr>
        <th class="product-image-col"></th>
        <th class="product-name-col">Name</th>
        <th class="product-media-col">Media</th>
        <th class="product-release-col">Release</th>
        <th class="product-price-col">Price</th>
        <th class="product-stock-col">Stock</th>
        <th class="product-delete-col"></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in products" :key="product.id" @click.prevent="onEdit(product)">
        <td>
          <img v-if="product.image" v-bind:src="product.image" alt="Product image" class="product-image">
          <img v-else src="../assets/product_placeholder.svg" alt="Product image" class="product-image">
        </td>
        <td>{{product.name}}</td>
        <td>{{product.media}}</td>
        <td>{{product.release}}</td>
        <td>$ {{product.unitPrice}}</td>
        <td>{{product.inStock}}</td>
        <td><a href="#" v-on:click.prevent.stop="onRemove(product.id)">remove</a></td>
      </tr>
      <tr v-if="!products.length">
        <td colspan="5" class="p-y-3 text-xs-center">
          <strong>You should add some products!</strong>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props: ['products'],
  methods: {
    onEdit (product) {
      this.$emit('edit', product)
    },
    onRemove (productId) {
      this.$emit('remove', productId)
    }
  }
}
</script>
