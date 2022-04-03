package appointment.booking;

import com.akkaserverless.javasdk.Context;
import com.akkaserverless.javasdk.DeferredCall;
import com.akkaserverless.javasdk.impl.DeferredCallImpl;
import com.akkaserverless.javasdk.impl.InternalContext;
import com.akkaserverless.javasdk.impl.MetadataImpl;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for direct instantiation, called by generated code, use Action.components() to access
 */
public final class ComponentsImpl implements Components {

  private final InternalContext context;

  public ComponentsImpl(Context context) {
    this.context = (InternalContext) context;
  }

  private <T> T getGrpcClient(Class<T> serviceClass) {
    return context.getComponentGrpcClient(serviceClass);
  }

  @Override
  public Components.AppointmentBookingEntityCalls appointmentBookingEntity() {
    return new AppointmentBookingEntityCallsImpl();
  }

  private final class AppointmentBookingEntityCallsImpl implements Components.AppointmentBookingEntityCalls {
     @Override
    public DeferredCall<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> createAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking) {
      return new DeferredCallImpl<>(
        addAppointmentBooking,
        MetadataImpl.Empty(),
        "appointment.booking.api.AppointmentBooking",
        "CreateAppointment",
        () -> getGrpcClient(appointment.booking.api.AppointmentBooking.class).createAppointment(addAppointmentBooking)
      );
    }
    @Override
    public DeferredCall<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> updateAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking addAppointmentBooking) {
      return new DeferredCallImpl<>(
        addAppointmentBooking,
        MetadataImpl.Empty(),
        "appointment.booking.api.AppointmentBooking",
        "UpdateAppointment",
        () -> getGrpcClient(appointment.booking.api.AppointmentBooking.class).updateAppointment(addAppointmentBooking)
      );
    }
    @Override
    public DeferredCall<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty> deleteAppointment(appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking deleteAppointmentBooking) {
      return new DeferredCallImpl<>(
        deleteAppointmentBooking,
        MetadataImpl.Empty(),
        "appointment.booking.api.AppointmentBooking",
        "DeleteAppointment",
        () -> getGrpcClient(appointment.booking.api.AppointmentBooking.class).deleteAppointment(deleteAppointmentBooking)
      );
    }
    @Override
    public DeferredCall<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointments(appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments getOwnerAppointments) {
      return new DeferredCallImpl<>(
        getOwnerAppointments,
        MetadataImpl.Empty(),
        "appointment.booking.api.AppointmentBooking",
        "FetchOwnerAppointments",
        () -> getGrpcClient(appointment.booking.api.AppointmentBooking.class).fetchOwnerAppointments(getOwnerAppointments)
      );
    }
    @Override
    public DeferredCall<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointments(appointment.booking.api.AppointmentBookingApi.GetVetAppointments getVetAppointments) {
      return new DeferredCallImpl<>(
        getVetAppointments,
        MetadataImpl.Empty(),
        "appointment.booking.api.AppointmentBooking",
        "FetchVetAppointments",
        () -> getGrpcClient(appointment.booking.api.AppointmentBooking.class).fetchVetAppointments(getVetAppointments)
      );
    }
  }
}
