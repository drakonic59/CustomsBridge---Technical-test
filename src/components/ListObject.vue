<template>
  <div class="shadow-sm bg-white rounded mt-2 mb-1">
    <div class="row">
      <country-flag class="col-3 flex" v-bind:country='country' size='small'/>
      <p class="col-1 mt-1 mr-5 p-0" >{{ formatRef }}</p>
      <p class="col-3 mt-1 m-0 p-0" >{{ formatEndDate }} </p>
    </div>
     <p> {{ formatDesc }} </p>
  </div>
</template>

<script>
export default {
  name: 'ListObject',
  props: [ 'country', 'reference', 'end', 'desc' ],
  data () {
    return {
    }
  },
  computed: {
    formatEndDate: function() {
      var date = new Date(this.end);
      return date.getDate() + "/" + (date.getMonth()+1) + "/" + date.getFullYear();
    },
    formatDesc: function() {
      if (this.desc.length > 200) {
        return this.desc.substring(0,200) + "...";
      }
      return this.desc;
    },
    formatRef: function() {
      if (this.reference.length > 8) {
        return this.reference.substring(0,8) + "...";
      }
      return this.reference;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
