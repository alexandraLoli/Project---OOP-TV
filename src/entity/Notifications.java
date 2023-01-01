package entity;

public final class Notifications {
    private final String movieName;
    private final String message;

    public Notifications(final String movieName,
                         final String message) {
        this.movieName = movieName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Notifications{"
                + "movieName='" + movieName + '\''
                + ", message='" + message + '\''
                + '}';
    }
}
