package appointment.booking.domain;

import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.CommandContext;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.akkaserverless.javasdk.impl.eventsourcedentity.EventSourcedEntityRouter;
import com.google.protobuf.Empty;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * An event sourced entity handler that is the glue between the Protobuf service <code>AppointmentBooking</code>
 * and the command and event handler methods in the <code>AppointmentBookingEntity</code> class.
 */
public class AppointmentBookingEntityRouter extends EventSourcedEntityRouter<AppointmentBookingDomain.AppointmentState, AppointmentBookingEntity> {

  public AppointmentBookingEntityRouter(AppointmentBookingEntity entity) {
    super(entity);
  }

  @Override
  public AppointmentBookingDomain.AppointmentState handleEvent(AppointmentBookingDomain.AppointmentState state, Object event) {
    if (event instanceof AppointmentBookingDomain.AppointmentCreated) {
      return entity().appointmentCreated(state, (AppointmentBookingDomain.AppointmentCreated) event);
    } else if (event instanceof AppointmentBookingDomain.AppointmentDeleted) {
      return entity().appointmentDeleted(state, (AppointmentBookingDomain.AppointmentDeleted) event);
    } else {
      throw new EventSourcedEntityRouter.EventHandlerNotFound(event.getClass());
    }
  }

  @Override
  public EventSourcedEntity.Effect<?> handleCommand(
      String commandName, AppointmentBookingDomain.AppointmentState state, Object command, CommandContext context) {
    switch (commandName) {

      case "CreateAppointment":
        return entity().createAppointment(state, (AppointmentBookingApi.AddAppointmentBooking) command);

      case "UpdateAppointment":
        return entity().updateAppointment(state, (AppointmentBookingApi.EditAppointmentBooking) command);

      case "DeleteAppointment":
        return entity().deleteAppointment(state, (AppointmentBookingApi.DeleteAppointmentBooking) command);

      case "FetchOwnerAppointments":
        return entity().fetchOwnerAppointments(state, (AppointmentBookingApi.GetOwnerAppointments) command);

      case "FetchVetAppointments":
        return entity().fetchVetAppointments(state, (AppointmentBookingApi.GetVetAppointments) command);

      default:
        throw new EventSourcedEntityRouter.CommandHandlerNotFound(commandName);
    }
  }
}
