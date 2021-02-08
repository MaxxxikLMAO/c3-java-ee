package cz.maxikek.netitletovatelne;


import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

    @ApplicationScoped
    public class Manager {

        private ArrayList<GameDetail> gameDetails = new ArrayList<>();
        public ArrayList<GameDetail> getGames(){
            return gameDetails;
        }
        public boolean create(GameDetail gameDetail) {
            if(gameDetail.getRating() < 0 || gameDetail.getRating() > 100)
                return false;
            int generatedId = (int) (Math.random()*(100 +1));
            if (gameCheck(generatedId)){
                gameDetail.setId(generatedId);
            }
            return true;
        }
        public GameDetail getGame (int id){
            return gameDetails.stream()
                    .filter(gameDetailStream -> id == gameDetailStream.getId())
                    .findAny()
                    .orElse(null);
        }
        public boolean removeGame(int id){
            return  gameDetails.remove(getGame(id));
        }
        public boolean gameCheck(int id) {
            for (int i = 0; i < 100; i++){
                if (id != gameDetails.get(id).id) {
                    return false;
                }
            }
            return true;
        }


}
