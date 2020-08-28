<template>
  <div id="app m-0">
    <div class="container-fluid">

      <nav class="row p-2 color-light b-bottom">
        <img src="" class="col-1 color-black"/>
        <input v-model="model_filter_on_code" class="col-4 mr-3 b-bottom color-light" placeholder="Taper votre code nomenclature" type="text" />
        <input v-model="model_search" class="col-6 b-bottom color-light" placeholder="Décrivez votre RTC" type="text" />
      </nav>

      <ListShower class="color-light" v-bind:filter="model_filter_on_code" v-bind:search="model_search" v-bind:limit="model_limit"/>

    </div>
  </div>
</template>

<script>
import ListShower from './components/ListShower'

export default {
  name: 'App',
  components: {
    ListShower
  },
  data () {
    return {
      isRequestOk: false,
      model_limit: 100,
      model_filter_on_code: '',
      model_search: ''
    }
  }
}
</script>

<style>
.color-light {
  background-color: #DEDFD7;
}
.color-black {
  color: black;
}
.b-bottom {
  border: none;
  border-bottom: solid 1px gray;
}
</style>
