<template>
<div id="App1"> 
  <!-- .prevent: 원하는 이벤트 외에 다른 이벤트 발생하는 상황 막음. 입력 데이터 전송 후 GET METHOD NOT ALLOWED 에러 발생 차단-->
 <form v-on:submit.prevent="onSubmitForm"> 
   <p> userid:
      <input type="text" v-model="id" id="id"> 
  </p>
  <p> userpassword:
      <input type="password" v-model="password" id="password"> 
  </p>
  <p> username:
      <input type="text" v-model="name" id="name"> 
  </p>
  <p> useremail:
      <input type="text" v-model="email" id="email"> 
  </p>
  <button v-on:click="onLoggin"> Signup </button>
  <p> {{id}} </p>
  <p> {{password}} </p>
  <p> {{name}} </p>
  <p> {{email}} </p>
  </form> 
  </div>    
</template>>

<script>
import axios from 'axios'
export default{
    name: "App1",
    data(){
        return{
            id:"",
            password:"",
            name:"",
            email:""
        };
    },
    methods : {
      onLoggin: function(){
            var data={
              id:this.id,
              password:this.password,
              name:this.name,
              email:this.email

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
                    //spring에서 보낸 status message 읽기
                    var result=response.data;
                    console.log(result.message);
                    var message=result.message;
                    //회원가입 성공한 경우
                    if(message.toString()=="Signup SUCCESS"){
                      alert("SUCCESS");
                    }
                    
                  })
                  .catch(e => {
                    console.log(e.response);
                    console.log(e.response.data);
                    //데이터 형식 어긋남
                    if(e.response.data=="MethodArgumentNotValidException")
                      alert("다시 입력해주세요");
                    // 이미 db에 존재하는 데이터
                    if(e.response.data=="DuplicateKeyException")
                      alert("이미 존재하는 데이터입니다");
                  })
            
                  }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>
