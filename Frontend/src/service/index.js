import axios from 'axios';

let URL_BASE ="http://localhost:8080/"

const getBooks = async()=>{
    try {
       const res= await axios.get(`${}`)
    } catch (error) {
        
    }
}
const getBooksByAuthor = async()=>{
        
}
const getBooksByDate = async()=>{
        
}
const addNewBook = async()=>{
        
}
const updateBook = async()=>{
        
}
