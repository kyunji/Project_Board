<template>
  <div id="app">
    <!-- 글 제목 작성 칸 -->
    <p> title:
      <input type="text" v-model="title" id="title"> 
    </p>
    <!-- 글 내용 작성 칸 -->
    <textarea
    rows=20
    cols=100
    >
    </textarea>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
  margin: 20px;
}
</style>