package appointment.booking;

import appointment.booking.api.AppointmentBookingApi;
import appointment.booking.domain.AppointmentBookingEntity;
import appointment.booking.domain.AppointmentBookingEntityProvider;
import com.akkaserverless.javasdk.AkkaServerless;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public final class AkkaServerlessFactory {

  public static AkkaServerless withComponents(
      Function<EventSourcedEntityContext, AppointmentBookingEntity> createAppointmentBookingEntity) {
    AkkaServerless akkaServerless = new AkkaServerless();
    return akkaServerless
      .register(AppointmentBookingEntityProvider.of(createAppointmentBookingEntity));
  }
}
