import { createRouter, createWebHistory } from "vue-router";
// @는 src를 가리킴
import Home from '@/pages/index.vue';
import Boards from '@/pages/boards/index.vue';
import BoardsCreate from '@/pages/boards/create/index.vue';
import Board from '@/pages/boards/_id.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/boards',
            name: 'Boards',
            component: Boards
        },
        {
            path: '/boards/create', //  /xxx/xxx 가 먼저  /xxx/:params 처럼 파라미터가 들어가는데 나중에 나와야됨
            name: 'BoardCreate',
            component: BoardsCreate
        },
        {
            path: '/boards/:id',  // :{변수이름} 일 때는 _xx.vue 로 파일 만듬
            name: 'Board',
            component: Board
        }
    ]
});

export default router;