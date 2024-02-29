<template>
  <div>
    <b-card-group deck>
        <b-row>
            <b-col cols="12" md="6" lg="4" v-for="(book,index) in books" :key="index" class="mb-4">
                <b-card draggable="true" @dragstart="dragStart(book)">
                    <b-card :title="book.title">
                        <b-card-text>{{ book.author}}</b-card-text>
                        <template #footer>
                            <small class="text-muted">Fecha de publicación: {{ formatDate(book.publicationDate)}}</small>
                        </template>
                    </b-card>
                </b-card>
            </b-col>
        </b-row>
    </b-card-group>
  </div>
</template>

<script>
export default {
props:['books'],
methods:{
    formatDate(dateString){
        const date = new Date(dateString);
        return date.toLocaleDateString();
    },
    dragStart(book){
        this.$emit('dragStart',book)
    }

}
}
</script>

<style>

</style>