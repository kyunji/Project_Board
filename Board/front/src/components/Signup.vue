<template>
<div id="App1"> 
 <form v-on:submit="onSubmitForm"> 
   <p> userid:
      <input type="text" v-model="userid" id="userid"> 
  </p>
  <p> userpassword:
      <input type="password" v-model="userpassword" id="userpassword"> 
  </p>
  <p> username:
      <input type="text" v-model="username" id="username"> 
  </p>
  <p> useremail:
      <input type="text" v-model="useremail" id="useremail"> 
  </p>
  <button v-on:click="onLoggin"> Signup </button>
  <p> {{userid}} </p>
  <p> {{userpassword}} </p>
  <p> {{username}} </p>
  <p> {{useremail}} </p>
  </form> 
  </div>    
</template>>

<script>
import axios from 'axios'
export default{
    name: "App1",
    data(){
        return{
            userid:"",
            userpassword:"",
            username:"",
            useremail:""
        };
    },
    methods : {
      onLoggin: function(){
            
            //const id = document.getElementById("id");
            //const pass = document.getElementById("pass");
            var data={
              userid:this.userid,
              userpassword:this.userpassword,
              username:this.username,
              useremail:this.useremail

            }
            axios.put('/signup',data)
                  /* {
                  headers: {
                      'Access-Control-Allow-Origin': '*',
                      'Content-Type': 'application/json; charset = utf-8'
                    }

                  }) */
                  .then(response => {
                    console.log(response);
                  })
                  .catch(e => {
                    console.log('error : ', e)
                  })
                  }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>
