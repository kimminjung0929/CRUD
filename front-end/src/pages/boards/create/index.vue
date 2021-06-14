<template>
    <form class="py-2">
        <div class="mb-3">
            <label for="board_title" class="form-label">Title</label>
            <input type="text" class="form-control" id="board_title">
        </div>
        <div class="mb-3">
            <label for="board_content" class="form-label">Content</label>
            <input type="password" class="form-control" id="board_content">
        </div>
        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary">수정</button>
            <button type="submit" class="btn btn-primary">생성</button>
            <router-link type="submit" class="btn btn-primary mx-2" to="/boards">취소</router-link>
        </div>
            
    </form>
</template>

<script>
export default {

}
</script>

<style>

</style>