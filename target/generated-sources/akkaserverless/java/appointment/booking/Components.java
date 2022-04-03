package appointment.booking;

import com.akkaserverless.javasdk.DeferredCall;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for user extension, provided through generated implementation
 */
public interface Components {
  AppointmentBookingEntityCalls appointmentBookingEntity();

  interface AppointmentBookingEntityCalls {
    DeferredCall<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> createAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking);

    DeferredCall<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> updateAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking);

    DeferredCall<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty> deleteAppointment(appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking deleteAppointmentBooking);

    DeferredCall<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointments(appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments getOwnerAppointments);

    DeferredCall<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointments(appointment.booking.api.AppointmentBookingApi.GetVetAppointments getVetAppointments);
  }
}
