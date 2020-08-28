<template>
  <div id="show" class="row">
    <div class="col-2" v-if="isRequestOk" v-for="item in jsonContent" v-bind:key="item">
      <ListObject country="item.issuing_country" ref="item.bti_ref" end="item.end_date"
                  desc="item.description_fr" />
    </div>
  </div>
</template>

<script>
import ListObject from './components/ListObject'

export default {
  name: 'ListShower',
  props: [ 'filter', 'search', 'limit' ],
  components: {
    ListObject
  },
  data () {
    return {
      jsonContent: '',
      isRequestOk: false
    }
  },
  async created () {
    let response = await fetch("https://api.customsbridge.ai/ebti?name=" + 
                                            this.filter + "&search=" +
                                            this.search + "&limit=" 
                                            + this.limit);
    if (response.ok) {
      this.jsonContent = await response.json();
      this.isRequestOk = true;
    } else {
      this.isRequestOk = false;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
