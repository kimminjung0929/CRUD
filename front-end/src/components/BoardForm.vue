<template>
    <form class="py-2" @submit.stop.prevent="onSave">
        <div class="mb-3">
            <label for="board_title" class="form-label">Title</label>
            <input type="text" class="form-control" id="board_title" v-model="board.title">
        </div>
        <div class="mb-3">
            <label for="board_content" class="form-label">Content</label>
            <input type="text" class="form-control" id="board_content" v-model="board.content">
        </div>
        <div style="color: red" v-if="valErr">{{ valErr }}</div>
        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary">{{ editing ? '수정' : '생성'}}</button>
            <router-link type="submit" class="btn btn-primary mx-2" v-bind:to="{name: 'Boards'}">취소</router-link>
        </div>
    </form>
</template>

<script>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from '@/axiosBaseURL.js';

export default {
    props: {
        // editing을 사용해서 create, edit를 나눈다
        // editing이 false면 create, true면 edit
        // setup() 인자로 props를 넣어 ediiting에 접근할 수 있게 한다.
        editing: { 
            type: Boolean,
            default: false
        }
    },

    setup(props) {
        // tampalte에서 props.editing을 접근할 때는 그냥 editing만 하면됨
        const route = useRoute(); // url의 params를 얻기위함
        const router = useRouter(); // router.push를 하기 위함
        const board = ref([]);
        const boardId = route.params.id

        const valErr = ref('');

        const getBoard = async (board_id) => {
            const res = await axios.get(`/boards/${board_id}`);

            board.value = res.data;
        }

        // editing이 true일 때만 id값으로 해당 글을 가져온다
        if (props.editing) {
            getBoard(boardId);
        }
        

        const onSave = async () => {
            valErr.value = '';
            if(!board.value.title || !board.value.content) {
                valErr.value = '글을 작성해 주세요';
                return;
            }

            if(props.editing) {
                await axios.put(`/boards/${boardId}`, {
                    title: board.value.title,
                    content: board.value.content
                });
                router.push({
                    name: 'Boards'
                }); 
            } else {
                await axios.post(`/boards`, {
                    title: board.value.title,
                    content: board.value.content
                }); 
                router.push({
                    name: 'Boards'
                });
            }
            
        }

        return {
            board,
            valErr,
            getBoard,
            onSave,
        }
    }
}
</script>

<style>

</style>