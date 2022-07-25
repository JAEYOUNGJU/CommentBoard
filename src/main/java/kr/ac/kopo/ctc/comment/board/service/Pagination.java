package kr.ac.kopo.ctc.comment.board.service;

public class Pagination {

   private int ppPage;   //<<: 첫 페이지로
   private int pPage;   //< : 이전 숫자 그룹의 첫 페이지로
   
   private int nPage;   //> : 다음 숫자 그룹의 첫 숫자
   private int nnPage;   //>> : 마지막 페이지로
   
   private int cPage;   // 현재 페이지
   private int startPage;   // 현재 그룹의 시작 페이지 번호
   private int lastPage;   // 현재 그룹의 마지막 페이지 번호
   
   private int countPerPage;   // 한 페이지에 나올 숫자 목록
   private int pageSize;   //한 페이지 목록 수
   private int totalCount;   //전체 목록 수
   private int totalPage;   //전체 페이지 수
   
   
   public int getPpPage() {
      return ppPage;
   }
   public void setPpPage(int ppPage) {
      this.ppPage = ppPage;
   }
   public int getpPage() {
      return pPage;
   }
   public void setpPage(int pPage) {
      this.pPage = pPage;
   }
   public int getnPage() {
      return nPage;
   }
   public void setnPage(int nPage) {
      this.nPage = nPage;
   }
   public int getNnPage() {
      return nnPage;
   }
   public void setNnPage(int nnPage) {
      this.nnPage = nnPage;
   }
   public int getcPage() {
      return cPage;
   }
   public void setcPage(int cPage) {
      this.cPage = cPage;
   }
   public int getStartPage() {
      return startPage;
   }
   public void setStartPage(int startPage) {
      this.startPage = startPage;
   }
   public int getLastPage() {
      return lastPage;
   }
   public void setLastPage(int lastPage) {
      this.lastPage = lastPage;
   }
   public int getCountPerpage() {
      return countPerPage;
   }
   public void setCountPerpage(int countPerpage) {
      this.countPerPage = countPerpage;
   }
   public int getPageSize() {
      return pageSize;
   }
   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }
   public int getTotalCount() {
      return totalCount;
   }
   public void setTotalCount(int totalCount) {
      this.totalCount = totalCount;
   }
   public int getTotalPage() {
      return totalPage;
   }
   public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
   }
   
   
   @Override
   public String toString() {
      return "Pagination [ppPage=" + ppPage + ", pPage=" + pPage + ", nPage=" + nPage + ", nnPage=" + nnPage
            + ", cPage=" + cPage + ", startPage=" + startPage + ", lastPage=" + lastPage + ", countPerpage="
            + countPerPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage=" + totalPage
            + "]";
   }
   
}