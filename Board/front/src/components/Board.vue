<template>
  <v-app>
  <v-main>
  <v-card >
    <v-form
      ref="form"
      v-model="form"
      class="pa-4 pt-6"
    >
    <h2 class="text-center"> Write </h2> 
      <v-text-field
        v-model="title"
        filled
        color="green darken-4"
        counter="1000"
        label="Title"
        style="min-height: 80px"
        :rules="title_rules"
      
      ></v-text-field>
        <v-textarea
          v-model="content"
          filled
          label="Content"
          value="내용을 입력하세요"
          :rules="content_rules"
        ></v-textarea>
      
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
        @click.prevent="insertBoard"
      >
        Save
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
            title:null,
            content:null,
            dialog:false,
            form:false,
            title_rules:[
              v=>!!v || '제목은 필수 입력사항입니다.',
              v=>!(v&&v.length>=1001) || '제목은 1000자 이상 입력할 수 없습니다.'
            ],
            content_rules:[
              v=>!!v || '내용은 필수 입력사항입니다.'
            ],
           
        };
    },
    methods :{
      insertBoard: function(){
        const data={
              title:this.title,
              content:this.content
            }
        console.log(data)
        this.$axios({
          method:"PUT",
          url:'http://localhost:8081/board',
          data:data
        })
        .then(response => {
                    console.log(response);
                  })
                  .catch(e => {
                    console.log(e.response);
                  })
      }
    }
}
</script>
<style>

</style>



