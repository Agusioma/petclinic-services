
// Generated by Akka gRPC. DO NOT EDIT.
package appointment.booking.api;

import akka.actor.ClassicActorSystemProvider;
import akka.stream.Materializer;
import akka.stream.SystemMaterializer;

import akka.grpc.internal.*;
import akka.grpc.GrpcClientSettings;
import akka.grpc.javadsl.AkkaGrpcClient;

import io.grpc.MethodDescriptor;

import static appointment.booking.api.AppointmentBooking.Serializers.*;

import scala.concurrent.ExecutionContext;


import akka.grpc.javadsl.SingleResponseRequestBuilder;


public abstract class AppointmentBookingClient extends AppointmentBookingClientPowerApi implements AppointmentBooking, AkkaGrpcClient {
  public static final AppointmentBookingClient create(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
    return new DefaultAppointmentBookingClient(settings, sys);
  }

  protected final static class DefaultAppointmentBookingClient extends AppointmentBookingClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final io.grpc.CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultAppointmentBookingClient(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
        this.settings = settings;
        this.mat = SystemMaterializer.get(sys).materializer();
        this.ec = sys.classicSystem().dispatcher();
        this.clientState = new ClientState(
          settings,
          akka.event.Logging$.MODULE$.apply(sys.classicSystem(), DefaultAppointmentBookingClient.class, akka.event.LogSource$.MODULE$.<DefaultAppointmentBookingClient>fromAnyClass()),
          sys);
        this.options = NettyClientUtils.callOptions(settings);

        sys.classicSystem().getWhenTerminated().whenComplete((v, e) -> close());
      }

  
    
      private final SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> createAppointmentRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(createAppointmentDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> updateAppointmentRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(updateAppointmentDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty> deleteAppointmentRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(deleteAppointmentDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointmentsRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(fetchOwnerAppointmentsDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointmentsRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(fetchVetAppointmentsDescriptor, channel, options, settings, ec);
      }
    
  

      

        /**
         * For access to method metadata use the parameterless version of createAppointment
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> createAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking request) {
          return createAppointment().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer createAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking) if possible.
         */
        
          public SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> createAppointment()
        
        {
          return createAppointmentRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of updateAppointment
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> updateAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking request) {
          return updateAppointment().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer updateAppointment(appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking) if possible.
         */
        
          public SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> updateAppointment()
        
        {
          return updateAppointmentRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of deleteAppointment
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> deleteAppointment(appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking request) {
          return deleteAppointment().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer deleteAppointment(appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking) if possible.
         */
        
          public SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty> deleteAppointment()
        
        {
          return deleteAppointmentRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of fetchOwnerAppointments
         */
        public java.util.concurrent.CompletionStage<appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointments(appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments request) {
          return fetchOwnerAppointments().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer fetchOwnerAppointments(appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments) if possible.
         */
        
          public SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointments()
        
        {
          return fetchOwnerAppointmentsRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of fetchVetAppointments
         */
        public java.util.concurrent.CompletionStage<appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointments(appointment.booking.api.AppointmentBookingApi.GetVetAppointments request) {
          return fetchVetAppointments().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer fetchVetAppointments(appointment.booking.api.AppointmentBookingApi.GetVetAppointments) if possible.
         */
        
          public SingleResponseRequestBuilder<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointments()
        
        {
          return fetchVetAppointmentsRequestBuilder(clientState.internalChannel());
        }
      

      
        private static MethodDescriptor<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> createAppointmentDescriptor =
          MethodDescriptor.<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("appointment.booking.api.AppointmentBooking", "CreateAppointment"))
            .setRequestMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking>(AddAppointmentBookingSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty> updateAppointmentDescriptor =
          MethodDescriptor.<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("appointment.booking.api.AppointmentBooking", "UpdateAppointment"))
            .setRequestMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.AddAppointmentBooking>(AddAppointmentBookingSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty> deleteAppointmentDescriptor =
          MethodDescriptor.<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("appointment.booking.api.AppointmentBooking", "DeleteAppointment"))
            .setRequestMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.DeleteAppointmentBooking>(DeleteAppointmentBookingSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchOwnerAppointmentsDescriptor =
          MethodDescriptor.<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments, appointment.booking.api.AppointmentBookingApi.Appointments>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("appointment.booking.api.AppointmentBooking", "FetchOwnerAppointments"))
            .setRequestMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.GetOwnerAppointments>(GetOwnerAppointmentsSerializer))
            .setResponseMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.Appointments>(AppointmentsSerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments> fetchVetAppointmentsDescriptor =
          MethodDescriptor.<appointment.booking.api.AppointmentBookingApi.GetVetAppointments, appointment.booking.api.AppointmentBookingApi.Appointments>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("appointment.booking.api.AppointmentBooking", "FetchVetAppointments"))
            .setRequestMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.GetVetAppointments>(GetVetAppointmentsSerializer))
            .setResponseMarshaller(new ProtoMarshaller<appointment.booking.api.AppointmentBookingApi.Appointments>(AppointmentsSerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public java.util.concurrent.CompletionStage<akka.Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public java.util.concurrent.CompletionStage<akka.Done> closed() {
        return clientState.closedCS();
      }
  }

}


