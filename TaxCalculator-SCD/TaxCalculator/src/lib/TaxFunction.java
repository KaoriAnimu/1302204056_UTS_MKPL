package lib ;

public class AnnualTaxCalculator {
    
    /**
     * Menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
     * 
     * @param salary - gaji pokok per bulan
	 * 
     * @param otherIncome - pemasukan lainnya per bulan
	 * 
     * @param monthsWorked - jumlah bulan bekerja per tahun
	 * 
     * @param deductible - pengurang pajak yang dapat diklaim
	 * 
     * @param isMarried - status pernikahan pegawai
	 * 
     * @param numberOfChildren - jumlah anak pegawai
     * 
     * @return jumlah pajak penghasilan pegawai yang harus dibayarkan setahun
     * 
     * @throws IllegalArgumentException jika monthsWorked lebih dari 12 atau numberOfChildren lebih dari 3
     */

    public static long calculateTax(long salary, long otherIncome, int monthsWorked, long deductible, boolean isMarried, int numberOfChildren) {
        if (monthsWorked > 12) {

            throw new IllegalArgumentException("Months worked cannot exceed 12") ;

        }
        
        if (numberOfChildren > 3) {

            throw new IllegalArgumentException("Number of children cannot exceed 3") ;

        }
        
        long taxExemptIncome = 54000000 ;

        if (isMarried) {

            taxExemptIncome += 4500000 ;

        }

        taxExemptIncome += numberOfChildren * 4500000 ;
        
        long taxableIncome = ((salary + otherIncome) * monthsWorked) - deductible - taxExemptIncome ;

        taxableIncome = Math.max(taxableIncome, 0) ;
        
        return Math.round(taxableIncome * 0.05) ;
    }
	
}
