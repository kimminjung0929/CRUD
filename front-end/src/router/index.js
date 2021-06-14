import { createRouter, createWebHistory } from "vue-router";
// @는 src를 가리킴
import Home from '@/pages/index.vue';
import Boards from '@/pages/boards/index.vue';
import BoardCreate from '@/pages/boards/create/index.vue'

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
            path: '/board/create',
            name: 'BoardCreate',
            component: BoardCreate
        },
    ]
});

export default router;