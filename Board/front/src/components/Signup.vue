<template>
  <v-app>
  <v-main>
  <v-card >
    <v-form
      ref="form"
      v-model="form"
      class="pa-4 pt-6"
    >
    <h2 class="text-center"> SignUp  </h2> 
      <v-text-field
        v-model="id"
        filled
        color="green darken-4"
        counter="20"
        label="Id"
        style="min-height: 80px"
        type="id"
        :rules="id_rules"
      
      ></v-text-field>
      <v-text-field
        v-model="password"
        filled
        color="green darken-4"
        counter="20"
        label="Password"
        style="min-height: 80px"
        type="password"
        :rules="password_rules"
      ></v-text-field>
      <v-text-field
        v-model="name"
        filled
        color="green darken-4"
        style="min-height: 80px"
        counter="40"
        label="Name"
        :rules="name_rules"
      ></v-text-field>
      <v-text-field
        v-model="email"
        filled
        color="green darken-4"
        style="min-height: 80px"
        counter="40"
        label="Email address"
        type="email"
        :rules="email_rules"
      ></v-text-field>
    </v-form>

    <v-divider></v-divider>

    <v-card-actions>
      <v-btn
        text
        @click="$refs.form.reset()"
      >
        Clear
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn
        :disabled="!form"
        class="white--text"
        color="green darken-4"
        depressed
        @click.prevent="onSignUp"
      >
        SignUp
      </v-btn>
    </v-card-actions>
    <v-dialog
      v-model="dialog"
      absolute
      max-width="400"
      persistent
    >
    </v-dialog>
  </v-card>
  </v-main>
  
</v-app>


</template>


<script>
  export default {
    data(){
        return{
            id:null,
            password:null,
            name:null,
            email:null,
            dialog:false,
            form:false,
            id_rules:[
              v=>!!v || '아이디는 필수 입력사항입니다.',
              v=>!(v&&v.length>=21) || '아이디는 20자 이상 입력할 수 없습니다.'
            ],
            password_rules:[
              v=>!!v || '비밀번호는 필수 입력사항입니다.',
              v=>!(v&&v.length>=21) || '비밀번호는 20자 이상 입력할 수 없습니다.'
            ],
            name_rules:[
              v=>!!v || '이름은 필수 입력사항입니다.',
              v=>!(v&&v.length>=41) || '이름은 40자 이상 입력할 수 없습니다.',
              v=>!/[~!@#$%^&&*()_+|<>?:{}]/.test(v) ||'이름에는 특수문자를 사용할 수 없습니다.'

            ],
            email_rules:[
              v=>!!v || '이메일은 필수 입력사항입니다.',
              v=>!(v&&v.length>=41) || '이메일은 40자 이상 입력할 수 없습니다.',
              v => !v || /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || '이메일 형식에 맞게 다시 입력하세요.'
            ]
        };
    },
    methods :{
      onSignUp: function(){
        const data={
              id:this.id,
              password:this.password,
              name:this.name,
              email:this.email

            }
        console.log(data)
        this.$axios({
          method:"PUT",
          url:'http://localhost:8081/signup',
          data:data
        })
        .then(response => {
                    console.log(response);
                    //spring에서 보낸 status message 읽기
                    let result=response.data;
                    console.log(result.message);
                    let message=result.message;
                    //회원가입 성공한 경우
                    if(message.toString()=="Signup SUCCESS"){
                      alert("SUCCESS");
                    }
                    
                  })
                  .catch(e => {
                    console.log(e.response);
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


