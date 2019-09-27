<template>
  <nav class="navbar navbar-expand-sm navbar-light navbar-jw">
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#appnav"
      aria-controls="appnav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand" href="#">
      <img src="../assets/jay.svg" alt="Jayway logo" /> BABYMETAL Store
    </a>

    <div class="collapse navbar-collapse" id="appnav">
      <div class="nav navbar-nav">
        <router-link
          to="home"
          class="nav-item nav-link"
          active-class="active"
          exact
        >
          Home
        </router-link>
        <router-link
          to="manage-products"
          class="nav-item nav-link"
          active-class="active"
          exact
        >
          Manage Products
        </router-link>
      </div>
      <div class="nav navbar-nav pull-sm-right">
        <div class="nav-item dropdown dropdown-cart">
          <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            <span v-if="totalItems" class="badge badge-pill badge-primary">{{totalItems}}</span> Shopping cart
          </a>
          <div class="dropdown-menu dropdown-menu-right">
            <shopping-cart></shopping-cart>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
import ShoppingCart from './ShoppingCart'
import { mapGetters } from 'vuex'

export default {
  components: {
    ShoppingCart
  },
  computed: {
    totalItems () {
      return this.inCart.reduce((sum, p) => sum + p.quantity, 0)
    },
    ...mapGetters({
      inCart: 'getCartItems'
    })
  }
}
</script>
