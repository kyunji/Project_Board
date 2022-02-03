<template>
  <v-app>
    <v-card
      color="grey lighten-4"
      flat
    >
      <v-app-bar
        color="green darken-2"
        dark
        dense
      >
        <v-app-bar-nav-icon @click="drawer = !drawer" />
        <v-toolbar-title> Blog </v-toolbar-title>
        <v-spacer />
      </v-app-bar>
    </v-card>
    <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
    >
      <v-list-item>
        <v-list-item-avatar>
          <v-icon>mdi-account</v-icon>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>User</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider />

      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.to"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
    <router-view />
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      drawer: false,
      items: [
        {
          title: 'Home',
          icon: 'mdi-home',
          to: '/'
        },
        {
          title: 'Signup',
          icon: 'mdi-account',
          to: '/signup'
        },
        {
          title: 'Login',
          icon: 'mdi-lock',
          to: '/login'
        },
        {
          title: 'Board',
          icon: 'mdi-pencil',
          to: '/board'
        },
      ]
    }
  },
}
</script>
