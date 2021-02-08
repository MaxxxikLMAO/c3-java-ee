package cz.maxikek.netitletovatelne;

    public class GameDetail {


        public String name, studio;
        public int id, rating;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStudio() {
            return studio;
        }

        public void setStudio(String studio) {
            this.studio = studio;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
