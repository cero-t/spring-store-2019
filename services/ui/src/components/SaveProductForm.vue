<template>
  <form>
    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.name }]">
      <label for="productName">Product name</label>
      <input type="text" v-model="product.name" class="form-control" id="productName" maxlength="32" placeholder="Enter product name">
      <div v-if="formErrors.name" class="form-control-feedback">{{formErrors.name}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.media }]">
      <label for="media">Product media</label>
      <input type="text" v-model="product.media" class="form-control" id="media" maxlength="256" placeholder="Enter image URL">
      <div v-if="formErrors.media" class="form-control-feedback">{{formErrors.media}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.release }]">
      <label for="release">Release Date</label>
      <input type="text" v-model="product.release" class="form-control" id="release" maxlength="256" placeholder="Enter image URL">
      <div v-if="formErrors.release" class="form-control-feedback">{{formErrors.release}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.unitPrice }]">
      <label for="unitPrice">Price</label>
      <input type="number" v-model="product.unitPrice" class="form-control" id="unitPrice" placeholder="Enter Price" number>
      <div v-if="formErrors.price" class="form-control-feedback">{{formErrors.unitPrice}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.image }]">
      <label for="image">Product image</label>
      <input type="text" v-model="product.image" class="form-control" id="image" maxlength="256" placeholder="Enter image URL">
      <div v-if="formErrors.image" class="form-control-feedback">{{formErrors.image}}</div>
    </div>

    <button type="submit" v-on:click.prevent="onSubmit" class="btn btn-primary">
      {{product.id ? 'Update' : 'Add'}} product
    </button>
    <button type="submit" v-if="product.id" v-on:click.prevent="onCancel" class="btn btn-secondary">Cancel</button>
  </form>
</template>

<script>
export default {
  props: ['product'],
  data () {
    return {
      formErrors: {},
      selectedFile: undefined,
      selectedFileName: ''
    }
  },
  watch: {
    'product.id' () {
      this.formErrors = {}
      this.selectedFile = undefined
      this.selectedFileName = this.product.imageName
    }
  },
  methods: {
    validateForm () {
      const errors = {}

      if (!this.product.name) {
        errors.name = 'Name is required'
      }

      if (!this.product.price) {
        errors.price = 'Price is required'
      }

      this.formErrors = errors

      return Object.keys(errors).length === 0
    },
    onCancel () {
      this.formErrors = {}

      this.$emit('cancel')
    },
    onSubmit () {
      if (this.validateForm()) {
        this.$emit('submit', this.product, this.selectedFile)
      }
    }
  }
}
</script>

<style scoped>
  form {
    margin-bottom: 24px;
  }
</style>
