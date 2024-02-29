<template>
  <div>
    <b-button @click="sortByAuthor">Ordenar por autor</b-button>
    <b-button @click="sortByDate">Ordenar por fecha</b-button>
    <b-button @click="insert">Agregar libro</b-button>
    <b-button @dragover.prevent @drop="edit">Editar</b-button>
    <b-button @dragover.prevent @drop="deleteBook">Eliminar</b-button>

  </div>
</template>

<script>
export default {
    methods:{
        sortByAuthor(){
            this.$emit('sortByAuthor');
        },
        sortByDate(){
            this.$emit('sortByDate');
        },
        insert(){
            this.$emit('insert');
        },
        edit(){
            this.$emit('edit');
        },
        deleteBook(){
            this.$emit('deleteBook');
        },
    }
}
</script>

<style>

</style>