package pms;

public class ParkingTicket {

	private String ticketNumber;
	private int slotNumber;
	private String vehicleId;
	public void saveInDB() {
		// TODO Auto-generated method stub
		
	}
	
	public String getTicketNumber() {
		// TODO Auto-generated method stub
		return this.ticketNumber;
	}

	public void setTicketNumber(String string) {
		// TODO Auto-generated method stub
		this.ticketNumber = string;
		
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

}
