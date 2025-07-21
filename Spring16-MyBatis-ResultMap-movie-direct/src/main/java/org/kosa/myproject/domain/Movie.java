package org.kosa.myproject.domain;
/**
 * 영화 정보를 저장하는 토메인 모델
 * Moive와 Director 간의 Many To One
 * 하나의 영화는 하나의 감독을 자니는 비즈니스 로직을 피룡
 */
public class Movie {
  private Long movieId;
  private String title;
  private String genre;
  private Long attendance;
  private Director director;
  
  public Movie() {
    super();
  }

  public Movie(Long movieId, String title, String genre, Long attendance, Director director) {
    super();
    this.movieId = movieId;
    this.title = title;
    this.genre = genre;
    this.attendance = attendance;
    this.director = director;
  }
  

  public Movie(String title, String genre, Long attendance, Director director) {
    super();
    this.title = title;
    this.genre = genre;
    this.attendance = attendance;
    this.director = director;
  }

  public Long getMovieId() {
    return movieId;
  }
  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public Long getAttendance() {
    return attendance;
  }
  public void setAttendance(Long attendance) {
    this.attendance = attendance;
  }
  public Director getDirector() {
    return director;
  }
  public void setDirector(Director director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", attendance=" + attendance
        + ", director=" + director + "]";
  }
}