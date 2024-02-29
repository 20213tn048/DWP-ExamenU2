<template>
  <div>
    <b-carousel
      id="carousel-id"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
<b-carousel-slide v-for="(book,index) in books" :key="index" img-src="https://picsum.photos/1024/480/?image=40">
    <h1>{{book.title}}</h1>
    <p>{{book.author}}</p>
    <p>{{formatDate(book.publicationDate)}}</p>
</b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
export default {
    props:['books'],
    data(){
        return{
            slide:0,
            sliding:null
        };
    },
    methods: {
        onSlideStart(slide){
            this.sliding = true;
        },
        onSlideEnd(slide){
            this.sliding = false;
        },
        formatDate(dateString){
            const date = new Date(dateString);
            return date.toLocaleDateString();
        }
    }
}
</script>

<style>

</style>