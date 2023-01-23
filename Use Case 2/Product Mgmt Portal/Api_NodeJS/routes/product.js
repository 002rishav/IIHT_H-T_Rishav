const express = require('express')
const router = express.Router()
// const Product = require('../models/product')

router.get('/', async(req,res) => {
    try{
        //    const product = await Product.find()
           res.json(product)
    }catch(err){
        res.send('Error ' + err)
    }
})

module.exports = router