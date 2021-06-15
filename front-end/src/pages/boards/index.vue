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
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td><button type="button" class="btn btn-danger btn-sm">delete</button></td>
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
                <router-link type="button" class="btn btn-primary btn-sm" to="/boards/create">글 작성</router-link>    
            </div>
            
        </div>
</template>

<script>
export default {

}
</script>

<style>

</style>