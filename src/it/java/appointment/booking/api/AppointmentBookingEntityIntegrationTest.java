package appointment.booking.api;

import appointment.booking.Main;
import appointment.booking.domain.AppointmentBookingDomain;
import com.akkaserverless.javasdk.testkit.junit.AkkaServerlessTestKitResource;
import com.google.protobuf.Empty;
import org.junit.ClassRule;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

// Example of an integration test calling our service via the Akka Serverless proxy
// Run all test classes ending with "IntegrationTest" using `mvn verify -Pit`
public class AppointmentBookingEntityIntegrationTest {

  /**
   * The test kit starts both the service container and the Akka Serverless proxy.
   */
  @ClassRule
  public static final AkkaServerlessTestKitResource testKit =
    new AkkaServerlessTestKitResource(Main.createAkkaServerless());

  /**
   * Use the generated gRPC client to call the service through the Akka Serverless proxy.
   */
  private final AppointmentBooking client;

  public AppointmentBookingEntityIntegrationTest() {
    client = testKit.getGrpcClient(AppointmentBooking.class);
  }

  @Test
  public void createAppointmentOnNonExistingEntity() throws Exception {
    // TODO: set fields in command, and provide assertions to match replies
    // client.createAppointment(AppointmentBookingApi.AddAppointmentBooking.newBuilder().build())
    //         .toCompletableFuture().get(5, SECONDS);
  }

  @Test
  public void updateAppointmentOnNonExistingEntity() throws Exception {
    // TODO: set fields in command, and provide assertions to match replies
    // client.updateAppointment(AppointmentBookingApi.AddAppointmentBooking.newBuilder().build())
    //         .toCompletableFuture().get(5, SECONDS);
  }

  @Test
  public void deleteAppointmentOnNonExistingEntity() throws Exception {
    // TODO: set fields in command, and provide assertions to match replies
    // client.deleteAppointment(AppointmentBookingApi.DeleteAppointmentBooking.newBuilder().build())
    //         .toCompletableFuture().get(5, SECONDS);
  }

  @Test
  public void fetchOwnerAppointmentsOnNonExistingEntity() throws Exception {
    // TODO: set fields in command, and provide assertions to match replies
    // client.fetchOwnerAppointments(AppointmentBookingApi.GetOwnerAppointments.newBuilder().build())
    //         .toCompletableFuture().get(5, SECONDS);
  }

  @Test
  public void fetchVetAppointmentsOnNonExistingEntity() throws Exception {
    // TODO: set fields in command, and provide assertions to match replies
    // client.fetchVetAppointments(AppointmentBookingApi.GetVetAppointments.newBuilder().build())
    //         .toCompletableFuture().get(5, SECONDS);
  }
}
