package appointment.booking.domain;

import appointment.booking.api.AppointmentBookingApi;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityOptions;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityProvider;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Empty;
import com.google.protobuf.EmptyProto;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * An event sourced entity provider that defines how to register and create the entity for
 * the Protobuf service <code>AppointmentBooking</code>.
 *
 * Should be used with the <code>register</code> method in {@link com.akkaserverless.javasdk.AkkaServerless}.
 */
public class AppointmentBookingEntityProvider implements EventSourcedEntityProvider<AppointmentBookingDomain.AppointmentState, AppointmentBookingEntity> {

  private final Function<EventSourcedEntityContext, AppointmentBookingEntity> entityFactory;
  private final EventSourcedEntityOptions options;

  /** Factory method of AppointmentBookingEntityProvider */
  public static AppointmentBookingEntityProvider of(Function<EventSourcedEntityContext, AppointmentBookingEntity> entityFactory) {
    return new AppointmentBookingEntityProvider(entityFactory, EventSourcedEntityOptions.defaults());
  }

  private AppointmentBookingEntityProvider(
      Function<EventSourcedEntityContext, AppointmentBookingEntity> entityFactory,
      EventSourcedEntityOptions options) {
    this.entityFactory = entityFactory;
    this.options = options;
  }

  @Override
  public final EventSourcedEntityOptions options() {
    return options;
  }

  public final AppointmentBookingEntityProvider withOptions(EventSourcedEntityOptions options) {
    return new AppointmentBookingEntityProvider(entityFactory, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return AppointmentBookingApi.getDescriptor().findServiceByName("AppointmentBooking");
  }

  @Override
  public final String entityType() {
    return "eventsourced-appointment-booking";
  }

  @Override
  public final AppointmentBookingEntityRouter newRouter(EventSourcedEntityContext context) {
    return new AppointmentBookingEntityRouter(entityFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {
      AppointmentBookingApi.getDescriptor(),
      AppointmentBookingDomain.getDescriptor(),
      EmptyProto.getDescriptor()
    };
  }
}
