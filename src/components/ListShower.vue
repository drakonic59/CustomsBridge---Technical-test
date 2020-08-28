<template>
  <div id="show" class="row">
    <div class="col-2" v-if="isRequestOk" v-for="item in jsonContent" v-bind:key="item">
      <ListObject v-bind:country="item.issuing_country" 
                  v-bind:reference="item.bti_ref" 
                  v-bind:end="item.end_date" 
                  v-bind:desc="item.description_fr" />
    </div>
  </div>
</template>

<script>
import ListObject from './ListObject'

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
    let response = await fetch("https://api.customsbridge.ai/ebti?filter_on_code=" + 
                                            this.filter + "&search=" +
                                            this.search + "&limit=" +
                                            this.limit);
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
