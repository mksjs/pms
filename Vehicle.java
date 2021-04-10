package pms;

public class Vehicle {
	private String vehicleId;
	private String licenseNumber;
	private VehicleType type;
	private ParkingTicket ticket;
	private String vehicleOwner;
	private VehicleColor color;
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public VehicleType getType() {
		return type;
	}
	public ParkingTicket getTicket() {
		return ticket;
	}
	public String getVehicleOwner() {
		return vehicleOwner;
	}
	public VehicleColor getColor() {
		return color;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public void setTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}
	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	public void setColor(VehicleColor color) {
		this.color = color;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
}
