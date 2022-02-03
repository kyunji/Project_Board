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
        counter="100"
        label="Title"
        style="min-height: 80px"
      
      ></v-text-field>
        <v-textarea
          filled
          name="input-7-4"
          label="Contents"
          value="내용을 입력하세요"
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
        @click.prevent="onSignUp"
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
 
</script>

