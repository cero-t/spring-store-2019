<template>
  <form>
    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.name }]">
      <label for="name">Name</label>
      <input type="text" v-model="order.name" class="form-control" id="name" maxlength="64" placeholder="Enter name">
      <div v-if="formErrors.name" class="form-control-feedback">{{formErrors.name}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.address }]">
      <label for="address">Address</label>
      <input type="text" v-model="order.address" class="form-control" id="address" maxlength="256" placeholder="Enter address">
      <div v-if="formErrors.address" class="form-control-feedback">{{formErrors.address}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.telephone }]">
      <label for="telephone">Phone Number</label>
      <input type="tel" v-model="order.telephone" class="form-control" id="telephone" maxlength="16" placeholder="Enter phone number">
      <div v-if="formErrors.telephone" class="form-control-feedback">{{formErrors.telephone}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.mailAddress }]">
      <label for="mailAddress">E-mail</label>
      <input type="email" v-model="order.mailAddress" class="form-control" id="mailAddress" maxlength="256" placeholder="Enter e-mail">
      <div v-if="formErrors.price" class="form-control-feedback">{{formErrors.mailAddress}}</div>
    </div>

    <div class="form-group" v-bind:class="[{ 'has-danger': formErrors.cardNumber }]">
      <label for="cardNumber">Card Number</label>
      <input type="text" v-model="order.cardNumber" class="form-control" id="cardNumber" maxlength="256" placeholder="Enter card number">
      <div v-if="formErrors.cardNumber" class="form-control-feedback">{{formErrors.cardNumber}}</div>
    </div>

    <button type="submit" @click.prevent="onSubmit" class="btn btn-primary">Purchase</button>
    <button type="submit" @click.prevent="onCancel" class="btn btn-secondary">Cancel</button>
  </form>
</template>

<script>
const initialData = () => {
  return {
    orderForm: {
      cartId: null,
      name: '',
      address: '',
      telephone: '',
      mailAddress: '',
      cardNumber: ''
    }
  }
}

export default {
  data () {
    return {
      formErrors: {},
      order: { ...initialData }
    }
  },
  methods: {
    validateForm () {
      const errors = {}

      if (!this.order.name) {
        errors.name = 'Name is required'
      }

      if (!this.order.address) {
        errors.address = 'Address is required'
      }

      // TODO: more

      this.formErrors = errors

      return Object.keys(errors).length === 0
    },
    onSubmit () {
      if (this.validateForm()) {
        this.$store.dispatch('checkout', this.order).then(() => {
          this.$router.push('/home')
        })
      }
    },
    onCancel () {
      this.formErrors = {}
      this.order = { ...initialData }
    }
  }
}
</script>

<style scoped>
  form {
    margin-bottom: 24px;
  }
</style>
