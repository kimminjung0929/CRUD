<template>

        <!-- 게시글 리스트 -->
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">글 번호</th>
                    <th scope="col">제목</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="board in boards" v-bind:key="board.id">
                    <td>{{ board.id }}</td>
                    <td style="cursor : pointer"><div @click.stop="moveToPage(board.id)">{{ board.title }}</div></td>
                    <td><button type="button" class="btn btn-danger btn-sm" @click.stop="deleteBoard(board.id)">delete</button></td>
                </tr>
            </tbody>
        </table>
        
        <hr>

        <!-- Pagination , 글 작성 버튼 -->
        <div class="d-flex justify-content-between">
            <div>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>    
            </div>
            <div>
                <button type="button" class="btn btn-primary btn-sm" @click.stop="moveToCreatePage">글 작성</button>    
            </div>
            
        </div>
</template>

<script>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/axiosBaseURL.js';

export default {
    setup() {
        const boards = ref([]);
        const router = useRouter();

        // 페이지 로딩 시 모든 글 가져오기
        const getBoards = async () => {
            const res = await axios.get(`/boards`)
            boards.value = res.data;    
            
        }
        getBoards();       
        
        // delete 버튼 눌러서 글 삭제하기        
        const deleteBoard = async (board_id) => {
            
            await axios.delete(`/boards/${board_id}`);
            getBoards();
        }

        // 해당 글 상세 페이지 이동
        const moveToPage = (board_id) => {
            router.push({
                name: 'Board',
                params: {
                    id: board_id
                }
            });
        }

        // 생성 페이지 이동
        const moveToCreatePage = () => {
            router.push({
                name: 'BoardCreate'
            })
        };

        return {
            boards,
            getBoards,
            deleteBoard,
            moveToPage,
            moveToCreatePage,
        }
    }
}
</script>

<style>

</style>