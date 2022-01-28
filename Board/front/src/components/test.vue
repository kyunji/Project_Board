<template>
<v-app>
  <v-card
    class="mx-auto"
    style="max-width: 1000px;"
  >
    <v-toolbar
      color="light-green darken-2"
      cards
      dark
      flat
    >
      <v-card-title class="text-h6 font-weight-regular">
        Sign up
      </v-card-title>
      <v-spacer></v-spacer>
    </v-toolbar>

    <v-form
      ref="form"
      v-model="form"
      class="pa-4 pt-6"
    >
      <v-text-field
        v-model="password"
        :rules="[rules.password, rules.length(6)]"
        filled
        color="green darken-4"
        counter="20"
        label="Password"
        style="min-height: 100px"
        type="password"
      ></v-text-field>
      <v-text-field
        v-model="phone"
        filled
        color="green darken-4"
        label="Phone number"
      ></v-text-field>
      <v-text-field
        v-model="email"
        :rules="[rules.email]"
        filled
        color="green darken-4"
        label="Email address"
        type="email"
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
        :loading="isLoading"
        class="white--text"
        color="deep-purple accent-4"
        depressed
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
</v-app>
</template>


<script>
  export default {
    data: () => ({
      agreement: false,
      dialog: false,
      email: undefined,
      form: false,
      isLoading: false,
      password: undefined,
      phone: undefined,
      rules: {
        email: v => !!(v || '').match(/@/) || 'Please enter a valid email',
        length: len => v => (v || '').length >= len || `Invalid character length, required ${len}`,
        password: v => !!(v || '').match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*(_|[^\w])).+$/) ||
          'Password must contain an upper case letter, a numeric character, and a special character',
        required: v => !!v || 'This field is required',
      },
    }),
  }
</script>