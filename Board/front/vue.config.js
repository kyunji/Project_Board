module.exports = {
  outputDir: "../src/main/resources/static",  
  indexPath: "../static/index.html",  
  devServer: {
    proxy:{
      '/': {
        "target": 'http://localhost:8080',
        "changeOrigin": true
        
    }
    },
    overlay: false
  },
  transpileDependencies: [
    'vuetify'
  ]

}
