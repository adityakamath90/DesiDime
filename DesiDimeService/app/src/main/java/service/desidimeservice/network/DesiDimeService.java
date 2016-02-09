package service.desidimeservice.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import service.desidimeservice.dto.DesiDimeData;
import service.desidimeservice.utility.Constants;

public interface DesiDimeService {
    @GET("{id}.json")
    Call<DesiDimeData> getOffers(@Path(Constants.ID) String id, @Header(Constants.KEY) String token);
}
