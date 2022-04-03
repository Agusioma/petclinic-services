package appointment.booking.domain;

import appointment.booking.Components;
import appointment.booking.ComponentsImpl;
import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.google.protobuf.Empty;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractAppointmentBookingEntity extends EventSourcedEntity<AppointmentBookingDomain.AppointmentState> {

  protected final Components components() {
    return new ComponentsImpl(commandContext());
  }

  public abstract Effect<Empty> createAppointment(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking);

  public abstract Effect<Empty> updateAppointment(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking);

  public abstract Effect<Empty> deleteAppointment(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingApi.DeleteAppointmentBooking deleteAppointmentBooking);

  public abstract Effect<AppointmentBookingApi.Appointments> fetchOwnerAppointments(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingApi.GetOwnerAppointments getOwnerAppointments);

  public abstract Effect<AppointmentBookingApi.Appointments> fetchVetAppointments(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingApi.GetVetAppointments getVetAppointments);

  public abstract AppointmentBookingDomain.AppointmentState appointmentCreated(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingDomain.AppointmentCreated appointmentCreated);

  public abstract AppointmentBookingDomain.AppointmentState appointmentDeleted(AppointmentBookingDomain.AppointmentState currentState, AppointmentBookingDomain.AppointmentDeleted appointmentDeleted);

}