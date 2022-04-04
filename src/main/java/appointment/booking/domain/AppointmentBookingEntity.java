package appointment.booking.domain;

import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.google.protobuf.Empty;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
// This is the implementation for the Event Sourced Entity Service described in your appointment/booking/api/appointment_booking_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class AppointmentBookingEntity extends AbstractAppointmentBookingEntity {

  @SuppressWarnings("unused")
  private final String entityId;

  public AppointmentBookingEntity(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public AppointmentBookingDomain.AppointmentState emptyState() {
    return AppointmentBookingDomain.AppointmentState.getDefaultInstance();
  }

  @Override
  public Effect<Empty> createAppointment(AppointmentBookingDomain.AppointmentState currentState,
                                         AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking) {
    AppointmentBookingDomain.AppointmentCreated appointmentCreatedEvent = AppointmentBookingDomain.AppointmentCreated
            .newBuilder()
            .setAppointment(AppointmentBookingDomain.AppointmentDetails.newBuilder()
                    .setAppointmentId(addAppointmentBooking.getAppointmentId())
                    .setAppointmentDate(addAppointmentBooking.getAppointmentDate())
                    .setAppointmentTime(addAppointmentBooking.getAppointmentTime())
                    .setAppointmentDesc(addAppointmentBooking.getAppointmentDesc())
                    //.setOwnerId(addAppointmentBooking.getOwnerId())
                    .setVetId(addAppointmentBooking.getVetId())
                    .build())
            .build();
    return effects().emitEvent(appointmentCreatedEvent).thenReply(__ -> Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> updateAppointment(AppointmentBookingDomain.AppointmentState currentState,
                                         AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking) {
    return effects().error("The command handler for `UpdateAppointment` is not implemented, yet");
  }

  @Override
  public Effect<Empty> deleteAppointment(AppointmentBookingDomain.AppointmentState currentState,
                                         AppointmentBookingApi.DeleteAppointmentBooking appointment) {
    if (findAppointmentById(currentState, appointment.getAppointmentId()).isEmpty()) {
      return effects()
              .error("Cannot remove item " + appointment.getAppointmentId() + " because it is not in the cart.");
    }

    AppointmentBookingDomain.AppointmentDeleted event = AppointmentBookingDomain.AppointmentDeleted.newBuilder()
            .setAppointmentId(appointment.getAppointmentId()).build();

    return effects().emitEvent(event).thenReply(newState -> Empty.getDefaultInstance());
  }

  private Optional<AppointmentBookingDomain.AppointmentDetails> findAppointmentById(
          AppointmentBookingDomain.AppointmentState appointment, String appointmentId) {
    Predicate<AppointmentBookingDomain.AppointmentDetails> appointmentDetailExists = appointmentDetail -> appointmentDetail
            .getAppointmentId().equals(appointmentId);
    return appointment.getBookingsList().stream().filter(appointmentDetailExists).findFirst();
  }

  @Override
  public Effect<AppointmentBookingApi.Appointments> fetchOwnerAppointments(
          AppointmentBookingDomain.AppointmentState currentState,
          AppointmentBookingApi.GetOwnerAppointments getOwnerAppointments) {
    List<AppointmentBookingApi.AppointmentDetails> apiAppointments = currentState.getBookingsList().stream()
            .map(this::convert)
            //.sorted(Comparator.comparing(AppointmentBookingApi.AppointmentDetails::getAppointmentId))
            .collect(Collectors.toList());
    AppointmentBookingApi.Appointments apiBoookings = AppointmentBookingApi.Appointments.newBuilder()
            .addAllBookings(apiAppointments).build();
    return effects().reply(apiBoookings);
  }


  private AppointmentBookingApi.AppointmentDetails convert(AppointmentBookingDomain.AppointmentDetails appointment) {
    return AppointmentBookingApi.AppointmentDetails.newBuilder().setAppointmentId(appointment.getAppointmentId())
            .setAppointmentDate(appointment.getAppointmentDate())
            .setAppointmentTime(appointment.getAppointmentTime())
            .setAppointmentDesc(appointment.getAppointmentDesc())
            //.setOwnerId(appointment.getOwnerId())
            .setVetId(appointment.getVetId()).build();
  }

  @Override
  public Effect<AppointmentBookingApi.Appointments> fetchVetAppointments(
          AppointmentBookingDomain.AppointmentState currentState,
          AppointmentBookingApi.GetVetAppointments getVetAppointments) {
    return effects().error("The command handler for `FetchVetAppointments` is not implemented, yet");
  }

  @Override
  public AppointmentBookingDomain.AppointmentState appointmentCreated(
          AppointmentBookingDomain.AppointmentState currentState,
          AppointmentBookingDomain.AppointmentCreated appointmentCreated) {
    Map<String, AppointmentBookingApi.AppointmentDetails> appointments = domainAppointmentToMap(currentState);
    AppointmentBookingApi.AppointmentDetails createdAppointment = appointments
            .get(appointmentCreated.getAppointment().getAppointmentId());
    AppointmentBookingDomain.AppointmentDetails appointmentDetails = appointmentCreated.getAppointment();
    createdAppointment = domainAppointmentToApi(appointmentDetails);
    // key value
    appointments.put(appointmentDetails.getAppointmentId(), createdAppointment);
    return mapAppointmentToDomain(appointments);
  }

  private AppointmentBookingApi.AppointmentDetails domainAppointmentToApi(
          AppointmentBookingDomain.AppointmentDetails appointmentDetails) {
    return AppointmentBookingApi.AppointmentDetails.newBuilder()
            .setAppointmentId(appointmentDetails.getAppointmentId())
            .setAppointmentDate(appointmentDetails.getAppointmentDate())
            .setAppointmentTime(appointmentDetails.getAppointmentTime())
            .setAppointmentDesc(appointmentDetails.getAppointmentDesc())
            //.setOwnerId(appointmentDetails.getOwnerId())
            .setVetId(appointmentDetails.getVetId())
            .build();
  }

  private Map<String, AppointmentBookingApi.AppointmentDetails> domainAppointmentToMap(
          AppointmentBookingDomain.AppointmentState appointmentState) {
    return appointmentState.getBookingsList().stream().collect(Collectors
            .toMap(AppointmentBookingDomain.AppointmentDetails::getAppointmentId, this::domainAppointmentToApi));
  }

  private AppointmentBookingDomain.AppointmentState mapAppointmentToDomain(
          Map<String, AppointmentBookingApi.AppointmentDetails> appointments) {
    return AppointmentBookingDomain.AppointmentState.newBuilder()
            .addAllBookings(
                    appointments.values().stream().map(this::apiAppointmentToDomain).collect(Collectors.toList()))
            .build();
  }

  private AppointmentBookingDomain.AppointmentDetails apiAppointmentToDomain(
          AppointmentBookingApi.AppointmentDetails appointmentDetails) {
    return AppointmentBookingDomain.AppointmentDetails.newBuilder()
            .setAppointmentId(appointmentDetails.getAppointmentId())
            .setAppointmentDate(appointmentDetails.getAppointmentDate())
            .setAppointmentTime(appointmentDetails.getAppointmentTime())
            .setAppointmentDesc(appointmentDetails.getAppointmentDesc())
            //.setOwnerId(appointmentDetails.getOwnerId())
            .setVetId(appointmentDetails.getVetId())
            .build();
  }

  @Override
  public AppointmentBookingDomain.AppointmentState appointmentDeleted(
          AppointmentBookingDomain.AppointmentState currentState,
          AppointmentBookingDomain.AppointmentDeleted appointmentDeleted) {
    List<AppointmentBookingDomain.AppointmentDetails> appointments = removeAppointmentById(currentState,
            appointmentDeleted.getAppointmentId());
    appointments.sort(Comparator.comparing(AppointmentBookingDomain.AppointmentDetails::getAppointmentId));
    return AppointmentBookingDomain.AppointmentState.newBuilder().addAllBookings(appointments).build();
  }

  private List<AppointmentBookingDomain.AppointmentDetails> removeAppointmentById(
          AppointmentBookingDomain.AppointmentState appointments, String appointmentId) {
    return appointments.getBookingsList().stream()
            .filter(appointmentDetails -> !appointmentDetails.getAppointmentId().equals(appointmentId))
            .collect(Collectors.toList());
  }

}