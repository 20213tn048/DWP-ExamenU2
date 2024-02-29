import axios from 'axios';

let URL_BASE ="http://localhost:8080/"

const getBooks = async()=>{
    try {
       const res= await axios.get(`${URL_BASE}api/books/`);
       return res.data;
    } catch (error) {
        throw error;
    }
}
const getBooksByAuthor = async()=>{
            try{
        const res = await axios.get(`${URL_BASE}api/books/author`)
        return res.data;
    }catch(error){
        throw error;
    }
}
const getBooksByDate = async()=>{
            try{
        const res = await axios.get(`${URL_BASE}api/books/publicationDate`)
        return res.data;
    }catch(error){
        throw error;
    }
}
const addNewBook = async()=>{
    try{
        const res = await axios.get(`${URL_BASE}api/books/`,book)
        return res.data;
    }catch(error){
        throw error;
    }
}
const updateBook = async(id, book) =>{
    try{
        const res = await axios.put(`${URL_BASE}api/books/${id}`,book);
        return res.data
    }catch(error){
        throw error;
    }
}

const deleteBook = async(id) =>{
    try{
        const res = await axios.delete(`${URL_BASE}api/books/${id}`);
        return res.data;
    }catch(error){
        throw error;
    }
}

export {
    getBooks,
    getBooksByAuthor,
    getBooksByDate,
    addNewBook,
    updateBook,
    deleteBook
}