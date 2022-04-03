package appointment.booking.domain;

import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.akkaserverless.javasdk.impl.effect.MessageReplyImpl;
import com.akkaserverless.javasdk.impl.effect.SecondaryEffectImpl;
import com.akkaserverless.javasdk.impl.eventsourcedentity.EventSourcedEntityEffectImpl;
import com.akkaserverless.javasdk.testkit.EventSourcedResult;
import com.akkaserverless.javasdk.testkit.impl.EventSourcedEntityEffectsRunner;
import com.akkaserverless.javasdk.testkit.impl.EventSourcedResultImpl;
import com.akkaserverless.javasdk.testkit.impl.TestKitEventSourcedEntityCommandContext;
import com.akkaserverless.javasdk.testkit.impl.TestKitEventSourcedEntityContext;
import com.akkaserverless.javasdk.testkit.impl.TestKitEventSourcedEntityEventContext;
import com.google.protobuf.Empty;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * TestKit for unit testing AppointmentBookingEntity
 */
public final class AppointmentBookingEntityTestKit extends EventSourcedEntityEffectsRunner<AppointmentBookingDomain.AppointmentState> {

  /**
   * Create a testkit instance of AppointmentBookingEntity
   * @param entityFactory A function that creates a AppointmentBookingEntity based on the given EventSourcedEntityContext,
   *                      a default entity id is used.
   */
  public static AppointmentBookingEntityTestKit of(Function<EventSourcedEntityContext, AppointmentBookingEntity> entityFactory) {
    return of("testkit-entity-id", entityFactory);
  }

  /**
   * Create a testkit instance of AppointmentBookingEntity with a specific entity id.
   */
  public static AppointmentBookingEntityTestKit of(String entityId, Function<EventSourcedEntityContext, AppointmentBookingEntity> entityFactory) {
    return new AppointmentBookingEntityTestKit(entityFactory.apply(new TestKitEventSourcedEntityContext(entityId)));
  }

  private AppointmentBookingEntity entity;

  /** Construction is done through the static AppointmentBookingEntityTestKit.of-methods */
  private AppointmentBookingEntityTestKit(AppointmentBookingEntity entity) {
     super(entity);
     this.entity = entity;
  }

  public AppointmentBookingDomain.AppointmentState handleEvent(AppointmentBookingDomain.AppointmentState state, Object event) {
    try {
      entity._internalSetEventContext(Optional.of(new TestKitEventSourcedEntityEventContext()));
      if (event instanceof AppointmentBookingDomain.AppointmentCreated) {
        return entity.appointmentCreated(state, (AppointmentBookingDomain.AppointmentCreated) event);
      } else if (event instanceof AppointmentBookingDomain.AppointmentDeleted) {
        return entity.appointmentDeleted(state, (AppointmentBookingDomain.AppointmentDeleted) event);
      } else {
        throw new NoSuchElementException("Unknown event type [" + event.getClass() + "]");
      }
    } finally {
      entity._internalSetEventContext(Optional.empty());
    }
  }

  public EventSourcedResult<Empty> createAppointment(AppointmentBookingApi.AddAppointmentBooking command) {
    return interpretEffects(() -> entity.createAppointment(getState(), command));
  }

  public EventSourcedResult<Empty> updateAppointment(AppointmentBookingApi.AddAppointmentBooking command) {
    return interpretEffects(() -> entity.updateAppointment(getState(), command));
  }

  public EventSourcedResult<Empty> deleteAppointment(AppointmentBookingApi.DeleteAppointmentBooking command) {
    return interpretEffects(() -> entity.deleteAppointment(getState(), command));
  }

  public EventSourcedResult<AppointmentBookingApi.Appointments> fetchOwnerAppointments(AppointmentBookingApi.GetOwnerAppointments command) {
    return interpretEffects(() -> entity.fetchOwnerAppointments(getState(), command));
  }

  public EventSourcedResult<AppointmentBookingApi.Appointments> fetchVetAppointments(AppointmentBookingApi.GetVetAppointments command) {
    return interpretEffects(() -> entity.fetchVetAppointments(getState(), command));
  }
}
