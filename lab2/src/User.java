/**
 * Created by wrachwal on 2018-03-13.
 */
public class User {
        private long id;
        private String name;
        private long numberOfStars;
        private long numberOfSentMessages;
        long getID()
        {
            return id;
        }
        String getName()
        {
            return name;
        }
        long getNumberOfStars()
        {
            return numberOfStars;
        }
        long getNumberOfSentMessages()
        {
            return numberOfSentMessages;
        }
        void setID(long idfun)
        {
            this.id = idfun;
        }
        void setName(String namefun)
        {
            this.name = namefun;
        }
        void setNumberOfStars(long numberOfStarsfun)
        {
            this.numberOfStars = numberOfStarsfun;
        }
        void setNumberOfSentMessages(long numberOfSentMessagesfun)
        {
            this.numberOfSentMessages = numberOfSentMessagesfun;
        }

}
