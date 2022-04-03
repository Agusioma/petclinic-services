package appointment.booking.domain;

import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.akkaserverless.javasdk.testkit.EventSourcedResult;
import com.google.protobuf.Empty;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class AppointmentBookingEntityTest {

  @Test
  public void exampleTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // use the testkit to execute a command
    // of events emitted, or a final updated state:
    // EventSourcedResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the emitted events
    // ExpectedEvent actualEvent = result.getNextEventOfType(ExpectedEvent.class);
    // assertEquals(expectedEvent, actualEvent)
    // verify the final state after applying the events
    // assertEquals(expectedState, testKit.getState());
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
  }

  @Test
  public void createAppointmentTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // EventSourcedResult<Empty> result = testKit.createAppointment(AddAppointmentBooking.newBuilder()...build());
  }


  @Test
  public void updateAppointmentTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // EventSourcedResult<Empty> result = testKit.updateAppointment(AddAppointmentBooking.newBuilder()...build());
  }


  @Test
  public void deleteAppointmentTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // EventSourcedResult<Empty> result = testKit.deleteAppointment(DeleteAppointmentBooking.newBuilder()...build());
  }


  @Test
  public void fetchOwnerAppointmentsTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // EventSourcedResult<Appointments> result = testKit.fetchOwnerAppointments(GetOwnerAppointments.newBuilder()...build());
  }


  @Test
  public void fetchVetAppointmentsTest() {
    AppointmentBookingEntityTestKit testKit = AppointmentBookingEntityTestKit.of(AppointmentBookingEntity::new);
    // EventSourcedResult<Appointments> result = testKit.fetchVetAppointments(GetVetAppointments.newBuilder()...build());
  }

}
