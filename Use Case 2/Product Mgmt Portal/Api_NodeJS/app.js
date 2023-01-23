const express = require('express')
const mongoose = require('mongoose')
const url = 'mongodb://localhost:27017/Products'

const app = express()

mongoose.set('strictQuery', true)
mongoose.connect(url, {useNewUrlParser:true})

const con = mongoose.connection
con.on('open', () => {
    console.log('connected...')
})

app.use(express.json())

const productRouter = require('./routes/product')
app.use('/product',productRouter)

app.listen(8088, () => {
    console.log('Server started')
})